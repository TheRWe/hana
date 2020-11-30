package cz.globex.hana.configuration

import com.github.javafaker.*
import cz.globex.hana.common.dto.*
import cz.globex.hana.database.entity.impl.*
import cz.globex.hana.database.repository.*
import org.springframework.context.annotation.*
import org.springframework.stereotype.*
import java.time.*
import java.util.*
import javax.annotation.*

@Profile("dev")
@Component
class ServerInitializer protected constructor(
	private val usersRepository: UsersRepository,
	private val adsRepository: AdsRepository,
	private val eventsRepository: EventsRepository,
	private val stockExchangesRepository: StockExchangesRepository,
	private val tagsRepository: TagsRepository,
) {
	private val faker = Faker()

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
				UserType.values().random(),
				photoUri = "/images/" + UUID.randomUUID() + ".png",
			)
		}
		usersRepository.saveAll(users)
	}

	fun initializeAds() {
		val ads = mutableSetOf<Ad>()
		repeat(ADS_COUNT) {
			val tags = mutableSetOf<String>()
			repeat((0..15).random()) {
				tags += faker.harryPotter().spell()
			}
			ads += Ad(
				author = usersRepository.getOne((1..USERS_COUNT).random().toLong()),
				name = faker.lorem().sentence((3..5).random()).removeSuffix("."),
				description = faker.harryPotter().quote(),
				type = AdType.values().random(),
				price = faker.number().digits((1..4).random()).toInt(),
				photoUri = "/images/" + UUID.randomUUID() + ".jpg",
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
			repeat((0..15).random()) {
				tags += faker.lordOfTheRings().location()
			}
			events += Event(
				author = usersRepository.getOne((1..USERS_COUNT).random().toLong()),
				name = faker.lorem().sentence((3..5).random()).removeSuffix("."),
				description = faker.hobbit().quote(),
				dateStartUtc = LocalDateTime.now().plusDays((1..10).random().toLong()),
				dateEndInclusiveUtc = LocalDateTime.now().plusDays((10..12).random().toLong()),
				price = faker.number().digits((1..4).random()).toInt(),
				photoUri = "/images/" + UUID.randomUUID() + ".jpg",
				place = null,
				tags = tagsRepository.saveAll(tags.map(Tag::newInstance)).toSet()
			)
		}
		eventsRepository.saveAll(events)
	}

	fun initializeStockExchanges() {
		val stockExchanges = mutableSetOf<StockExchange>()
		repeat(STOCK_EXCHANGES_COUNT) {
			val tags = mutableSetOf<String>()
			repeat((0..15).random()) {
				tags += faker.pokemon().name()
			}
			stockExchanges += StockExchange(
				author = usersRepository.getOne((1..USERS_COUNT).random().toLong()),
				name = faker.lorem().sentence((3..5).random()).removeSuffix("."),
				description = faker.gameOfThrones().quote(),
				type = StockExchangeType.values().random(),
				price = faker.number().digits((1..4).random()).toInt(),
				photoUri = "/images/" + UUID.randomUUID() + faker.file().extension(),
				place = null,
				tags = tagsRepository.saveAll(tags.map(Tag::newInstance)).toSet()
			)
		}
		stockExchangesRepository.saveAll(stockExchanges)
	}
}