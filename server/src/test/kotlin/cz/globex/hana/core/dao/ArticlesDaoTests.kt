package cz.globex.hana.core.dao

import cz.globex.hana.core.*
import cz.globex.hana.core.dto.*
import cz.globex.hana.database.entity.*
import cz.globex.hana.database.repository.*
import org.junit.jupiter.api.*
import org.springframework.beans.factory.annotation.*
import org.springframework.boot.test.context.*
import org.springframework.transaction.annotation.*
import kotlin.math.*

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ArticlesDaoTests {
	@Autowired
	private lateinit var articlesRepository: ArticlesRepository

	@Autowired
	private lateinit var daoProvider: DaoProvider

	private val articlesDao get() = daoProvider.articlesDao

	companion object {
		private const val EXAMPLE_TITLE = "Some title"
		private const val EXAMPLE_TEXT = "Some long text."

		private const val ARTICLES_COUNT = 10
		private const val PAGE_SIZE = 3
	}

	@BeforeAll
	fun initializeDb() {
		val articles = (1..ARTICLES_COUNT).map {
			Article.from(ArticleCreateUpdateDto("$EXAMPLE_TITLE $it", "$EXAMPLE_TEXT $it"))
		}
		articlesRepository.saveAll(articles)
	}

	@Test
	fun `Get all articles`() {
		val articles = articlesDao.getArticles()
		Assertions.assertEquals(ARTICLES_COUNT, articles.size)
	}

	@Test
	fun `Get articles with paging`() {
		val pagesCount = ceil(ARTICLES_COUNT / PAGE_SIZE.toDouble()).toInt()
		repeat(pagesCount) { pageStart ->
			val articles = articlesDao.getArticles(pageStart = pageStart, pageSize = PAGE_SIZE)
			Assertions.assertTrue(articles.size in 1..PAGE_SIZE)
		}
	}

	@Test
	fun `Get articles with only pageStart`() {
		Assertions.assertEquals(ARTICLES_COUNT, articlesDao.getArticles(pageStart = 0).size)
	}

	@Test
	fun `Get articles with only pageSize`() {
		Assertions.assertEquals(ARTICLES_COUNT, articlesDao.getArticles(pageSize = PAGE_SIZE).size)
	}

	@Test
	@Transactional
	fun `Create one article`() {
		val article = ArticleCreateUpdateDto("Some title", "Some long text.")
		val articleId = articlesDao.createArticle(article)
		val articles: Iterable<Article> = articlesRepository.findAll()
		val articlesCount = @Suppress("ReplaceCollectionCountWithSize") articles.count()
		Assertions.assertEquals(ARTICLES_COUNT + 1, articlesCount)

		val savedArticle = articlesRepository.getById(articleId)
		Assertions.assertNotNull(savedArticle)
	}

	@Test
	@Transactional
	fun `Create two articles with the same title and text`() {
		val article = ArticleCreateUpdateDto("Some title", "Some long text.")
		val firstArticleId = articlesDao.createArticle(article)
		val secondArticleId = articlesDao.createArticle(article)
		val articles: Iterable<Article> = articlesRepository.findAll()
		val articlesCount = @Suppress("ReplaceCollectionCountWithSize") articles.count()
		Assertions.assertEquals(ARTICLES_COUNT + 2, articlesCount)

		val firstSavedArticle = articlesRepository.getById(firstArticleId)
		Assertions.assertNotNull(firstSavedArticle)

		val secondSavedArticle = articlesRepository.getById(secondArticleId)
		Assertions.assertNotNull(secondSavedArticle)
	}

	@Test
	@Transactional
	fun `Create one article with blank title`() {
		val article = ArticleCreateUpdateDto(" ", "Some long text.")
		Assertions.assertThrows(IllegalArgumentException::class.java) {
			articlesDao.createArticle(article)
		}
	}

	@Test
	@Transactional
	fun `Create one article with blank text`() {
		val article = ArticleCreateUpdateDto("Some title", " ")
		Assertions.assertThrows(IllegalArgumentException::class.java) {
			articlesDao.createArticle(article)
		}
	}

	@Test
	fun `Get article`() {
		for (index in 1..ARTICLES_COUNT) {
			val article = articlesDao.getArticleOrNull(index)
			checkNotNull(article)

			Assertions.assertEquals("$EXAMPLE_TITLE $index", article.title)
			Assertions.assertEquals("$EXAMPLE_TEXT $index", article.text)
		}
	}

	@Test
	fun `Get nonexistent article`() {
		Assertions.assertNull(articlesDao.getArticleOrNull(ARTICLES_COUNT + 1))
	}
}