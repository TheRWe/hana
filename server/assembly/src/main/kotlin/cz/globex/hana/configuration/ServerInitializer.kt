package cz.globex.hana.configuration

import com.github.javafaker.*
import cz.globex.hana.common.dto.*
import cz.globex.hana.database.entity.impl.*
import cz.globex.hana.database.repository.impl.*
import org.springframework.context.annotation.*
import org.springframework.stereotype.*
import java.time.*
import javax.annotation.*
import kotlin.random.*

@Profile("dev")
@Component
class ServerInitializer protected constructor(
	private val usersRepository: UsersRepository,
	private val adsRepository: AdsRepository,
	private val eventsRepository: EventsRepository,
	private val stockExchangesRepository: StockExchangesRepository,
	private val tagsRepository: TagsRepository,
	private val adRatingsRepository: AdRatingsRepository,
	private val eventRatingsRepository: EventRatingsRepository,
	private val stockExchangeRatingsRepository: StockExchangeRatingsRepository,
) {
	private val random = Random(31)
	private val faker = Faker(random.asJavaRandom())

	private companion object {
		const val USERS_COUNT = 100
		const val ADS_COUNT = USERS_COUNT / 2
		const val EVENTS_COUNT = USERS_COUNT / 4
		const val STOCK_EXCHANGES_COUNT = USERS_COUNT * 10
	}

	@PostConstruct
	fun initialize() {
		initializeUsers()
		initializeAds()
		initializeEvents()
		initializeStockExchanges()
		initializeRatings()
	}

	private fun initializeUsers() {
		val users = mutableSetOf<User>()
		repeat(USERS_COUNT) {
			val firstName: String = faker.name().firstName()
			val lastName: String = faker.name().lastName()
			users += User(
				firstName = firstName,
				lastName = lastName,
				email = faker.internet().emailAddress("$firstName.$lastName".toLowerCase()),
				type = UserType.values().random(random),
				photoUri = "/images/" + faker.internet().uuid() + ".png",
			)
		}
		usersRepository.saveAll(users)
	}

	private fun initializeAds() {
		val ads = mutableSetOf<Ad>()
		repeat(ADS_COUNT) {
			val tags = mutableSetOf<String>()
			repeat(faker.number().numberBetween(0, 16)) {
				tags += faker.harryPotter().spell()
			}
			ads += Ad(
				author = usersRepository.getOne(faker.number().numberBetween(1L, USERS_COUNT.toLong() + 1)),
				name = faker.lorem().sentence(faker.number().numberBetween(3, 6)).removeSuffix("."),
				description = faker.harryPotter().quote(),
				type = AdType.values().random(random),
				price = faker.number().digits(faker.number().numberBetween(1, 5)).toInt(),
				photoUri = "/images/" + faker.internet().uuid() + ".jpg",
				place = null,
				tags = tagsRepository.saveAll(tags.map { Tag(it) }).toSet()
			)
		}
		adsRepository.saveAll(ads)
	}

	private fun initializeEvents() {
		val events = mutableSetOf<Event>()
		repeat(EVENTS_COUNT) {
			val tags = mutableSetOf<String>()
			repeat(faker.number().numberBetween(0, 16)) {
				tags += faker.lordOfTheRings().location()
			}
			events += Event(
				author = usersRepository.getOne(faker.number().numberBetween(1L, USERS_COUNT.toLong() + 1)),
				name = faker.lorem().sentence(faker.number().numberBetween(3, 6)).removeSuffix("."),
				description = faker.hobbit().quote(),
				dateStartUtc = LocalDateTime.now().plusDays(faker.number().numberBetween(1L, 11L)),
				dateEndInclusiveUtc = LocalDateTime.now().plusDays(faker.number().numberBetween(10L, 13L)),
				price = faker.number().digits(faker.number().numberBetween(1, 5)).toInt(),
				photoUri = "/images/" + faker.internet().uuid() + ".png",
				place = null,
				tags = tagsRepository.saveAll(tags.map { Tag(it) }).toSet())
		}
		eventsRepository.saveAll(events)
	}

	private fun initializeStockExchanges() {
		val stockExchanges = mutableSetOf<StockExchange>()
		repeat(STOCK_EXCHANGES_COUNT) {
			val tags = mutableSetOf<String>()
			repeat(faker.number().numberBetween(0, 16)) {
				tags += faker.pokemon().name()
			}
			stockExchanges += StockExchange(
				author = usersRepository.getOne(faker.number().numberBetween(1L, USERS_COUNT.toLong() + 1)),
				name = faker.lorem().sentence(faker.number().numberBetween(3, 6)).removeSuffix("."),
				description = faker.gameOfThrones().quote(),
				type = StockExchangeType.values().random(random),
				price = faker.number().digits(faker.number().numberBetween(1, 5)).toInt(),
				photoUri = "/images/" + faker.internet().uuid() + ".jpg",
				place = null,
				tags = tagsRepository.saveAll(tags.map { Tag(it) }).toSet()
			)
		}
		stockExchangesRepository.saveAll(stockExchanges)
	}

	private fun initializeRatings() {
		val adRatings = mutableSetOf<AdRating>()
		(USERS_COUNT + 1..USERS_COUNT + ADS_COUNT).forEach {
			val ad = adsRepository.getOne(it.toLong())
			val raters: MutableSet<Long> = mutableSetOf()
			repeat(faker.number().numberBetween(0, 6)) {
				val rater = usersRepository.getOne(faker.number().numberBetween(1L, USERS_COUNT.toLong() + 1))
				if (rater.id_safe !in raters) {
					raters += rater.id_safe
					adRatings += AdRating(rater, ad, RatingScore.values().random(random))
				}
			}
		}
		adRatingsRepository.saveAll(adRatings)

		val eventRatings = mutableSetOf<EventRating>()
		(USERS_COUNT + ADS_COUNT + 1..USERS_COUNT + ADS_COUNT + EVENTS_COUNT).forEach {
			val event = eventsRepository.getOne(it.toLong())
			val raters: MutableSet<Long> = mutableSetOf()
			repeat(faker.number().numberBetween(0, 16)) {
				val rater = usersRepository.getOne(faker.number().numberBetween(1L, USERS_COUNT.toLong() + 1))
				if (rater.id_safe !in raters) {
					raters += rater.id_safe
					eventRatings += EventRating(rater, event, RatingScore.values().random(random))
				}
			}
		}
		eventRatingsRepository.saveAll(eventRatings)

		val stockExchangeRatings = mutableSetOf<StockExchangeRating>()
		(USERS_COUNT + ADS_COUNT + EVENTS_COUNT + 1..USERS_COUNT + ADS_COUNT + EVENTS_COUNT + STOCK_EXCHANGES_COUNT).forEach {
			val stockExchange = stockExchangesRepository.getOne(it.toLong())
			repeat(faker.number().numberBetween(0, 2)) {
				val rater = usersRepository.getOne(faker.number().numberBetween(1L, USERS_COUNT.toLong() + 1))
				stockExchangeRatings += StockExchangeRating(rater, stockExchange, RatingScore.values().random(random))
			}
		}
		stockExchangeRatingsRepository.saveAll(stockExchangeRatings)

	}
}