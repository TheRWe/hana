package cz.globex.hana.core.dto

import cz.globex.hana.common.dto.*
import cz.globex.hana.database.entity.*
import cz.globex.hana.database.entity.impl.*

internal fun User.toDto(): UserDto {
	val ratingAsSupplier = ratingScoreAsSupplier
		?.let { RatingSummaryDto(it, ratingVotesAsSupplier) }
	val ratingAsSeller = ratingScoreAsSeller?.let { RatingSummaryDto(it, ratingVotesAsSeller) }
	return UserDto(
		id = id_safe,
		firstName = firstName,
		lastName = lastName,
		email = email,
		type = type,
		registeredUtc = registeredUtc,
		photoUri = photoUri,
		ratings = UserRatingSummariesDto(ratingAsSupplier, ratingAsSeller)
	)
}

internal fun Ad.toDto(): AdDto =
	AdDto(
		id = id_safe,
		authorId = author_safe.id_safe,
		name = name,
		description = description,
		place = place?.toDto(),
		photoUri = photoUri,
		tags = tags.mapTo(mutableSetOf(), Tag::name),
		createdUtc = createdUtc_safe,
		isActual = isActual,
		payout = price,
		type = type
	)

internal fun Event.toDto(): EventDto =
	EventDto(
		id = id_safe,
		authorId = author_safe.id_safe,
		name = name,
		description = description,
		place = place?.toDto(),
		photoUri = photoUri,
		tags = tags.mapTo(mutableSetOf(), Tag::name),
		createdUtc = createdUtc_safe,
		rating = ratingScore?.let { RatingSummaryDto(it, ratingVotes) },
		date = RangeDto(dateStartUtc, dateEndInclusiveUtc),
		entryFee = price
	)

internal fun StockExchange.toDto(): StockExchangeDto =
	StockExchangeDto(
		id = id_safe,
		authorId = author_safe.id_safe,
		name = name,
		description = description,
		place = place?.toDto(),
		photoUri = photoUri,
		tags = tags.mapTo(mutableSetOf(), Tag::name),
		createdUtc = createdUtc_safe,
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

internal fun Rating.toDto(): RatingDto =
	RatingDto(
		id = id_safe,
		authorId = author_safe.id_safe,
		score = RatingScore.values()[score_safe - 1]
	)