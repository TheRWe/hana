package cz.globex.hana.configuration

import com.github.javafaker.*
import cz.globex.hana.common.dto.*
import cz.globex.hana.database.entity.impl.*
import cz.globex.hana.database.repository.*
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
	}

	fun initializeUsers() {
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

	fun initializeAds() {
		val ads = mutableSetOf<Ad>()
		repeat(ADS_COUNT) {
			val tags = mutableSetOf<String>()
			repeat(faker.number().numberBetween(0, 15)) {
				tags += faker.harryPotter().spell()
			}
			ads += Ad(
				author = usersRepository.getOne(faker.number().numberBetween(1L, USERS_COUNT.toLong())),
				name = faker.lorem().sentence(faker.number().numberBetween(3, 5)).removeSuffix("."),
				description = faker.harryPotter().quote(),
				type = AdType.values().random(random),
				price = faker.number().digits(faker.number().numberBetween(1, 4)).toInt(),
				photoUri = "/images/" + faker.internet().uuid() + ".jpg",
				place = null,
				tags = tagsRepository.saveAll(tags.map(Tag::newInstance)).toSet()
			)
		}
		adsRepository.saveAll(ads)
	}

	fun initializeEvents() {
		val events = mutableSetOf<Event>()
		repeat(EVENTS_COUNT) {
			val tags = mutableSetOf<String>()
			repeat(faker.number().numberBetween(0, 15)) {
				tags += faker.lordOfTheRings().location()
			}
			events += Event(
				author = usersRepository.getOne(faker.number().numberBetween(1L, USERS_COUNT.toLong())),
				name = faker.lorem().sentence(faker.number().numberBetween(3, 5)).removeSuffix("."),
				description = faker.hobbit().quote(),
				dateStartUtc = LocalDateTime.now().plusDays(faker.number().numberBetween(1L, 10L)),
				dateEndInclusiveUtc = LocalDateTime.now().plusDays(faker.number().numberBetween(10L, 12L)),
				price = faker.number().digits(faker.number().numberBetween(1, 4)).toInt(),
				photoUri = "/images/" + faker.internet().uuid() + ".png",
				place = null,
				tags = tagsRepository.saveAll(tags.map(Tag::newInstance)).toSet())
		}
		eventsRepository.saveAll(events)
	}

	fun initializeStockExchanges() {
		val stockExchanges = mutableSetOf<StockExchange>()
		repeat(STOCK_EXCHANGES_COUNT) {
			val tags = mutableSetOf<String>()
			repeat(faker.number().numberBetween(0, 15)) {
				tags += faker.pokemon().name()
			}
			stockExchanges += StockExchange(
				author = usersRepository.getOne(faker.number()
					.numberBetween(1L, USERS_COUNT.toLong())),
				name = faker.lorem().sentence(faker.number().numberBetween(3, 5)).removeSuffix("."),
				description = faker.gameOfThrones().quote(),
				type = StockExchangeType.values().random(random),
				price = faker.number().digits(faker.number().numberBetween(1, 4)).toInt(),
				photoUri = "/images/" + faker.internet().uuid() + ".jpg",
				place = null,
				tags = tagsRepository.saveAll(tags.map(Tag::newInstance)).toSet()
			)
		}
		stockExchangesRepository.saveAll(stockExchanges)
	}
}