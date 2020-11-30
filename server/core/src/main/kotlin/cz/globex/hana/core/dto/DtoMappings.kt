package cz.globex.hana.core.dto

import cz.globex.hana.common.dto.*
import cz.globex.hana.database.entity.impl.*

internal fun User.toDto(): UserDto =
	UserDto(
		id = id,
		firstName = firstName,
		lastName = lastName,
		email = email,
		type = type,
		registeredUtc = registeredUtc, // TODO: respect timezones
		photoUri = photoUri,
		ratings = UserRatingsDto(null, null) // TODO
	)

internal fun Ad.toDto(): AdDto =
	AdDto(
		id = id,
		authorId = author.id,
		name = name,
		description = description,
		place = place?.toDto(),
		photoUri = photoUri,
		tags = tags.mapTo(mutableSetOf(), Tag::name),
		createdUtc = createdUtc, // TODO: respect timezones
		isActual = isActual,
		payout = price,
		type = type
	)

internal fun Event.toDto(): EventDto =
	EventDto(
		id = id,
		authorId = author.id,
		name = name,
		description = description,
		place = place?.toDto(),
		photoUri = photoUri,
		tags = tags.mapTo(mutableSetOf(), Tag::name),
		createdUtc = createdUtc, // TODO: respect timezones
		rating = RatingDto(0.0, 0),
		date = RangeDto(dateStartUtc, dateEndInclusiveUtc),
		entryFee = price
	)

internal fun StockExchange.toDto(): StockExchangeDto =
	StockExchangeDto(
		id = id,
		authorId = author.id,
		name = name,
		description = description,
		place = place?.toDto(),
		photoUri = photoUri,
		tags = tags.mapTo(mutableSetOf(), Tag::name),
		createdUtc = createdUtc,
		isActual = isActual,
		type = type,
		cost = price
	)

internal fun Place.toDto(): PlaceDto =
	PlaceDto(
		name = "$street $houseNumber, $city", // TODO: respect regional formats
		latitude = latitude,
		longitude = longitude
	)