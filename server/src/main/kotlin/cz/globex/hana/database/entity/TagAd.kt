package cz.globex.hana.database.entity

import java.net.*
import java.time.*
import javax.persistence.*

@Suppress("ProtectedInFinal")
@Entity
data class TagAd protected constructor(
    // ?
    @ManyToOne(nullable = false)
    var tag: Tag,

    // ?
    @ManyToOne(nullable = false)
    var ad: Ad
) {
    @Id
    @GeneratedValue
    @Column(updatable = false)
    val id: Int = 0

    // companion object {
    //     fun newInstance(
    //         tagId: Int,
    //         adId: Int
    //     ): TagAd {
    //         return TagAd(tagId, adId)
    //     }
    // }

    // protected constructor() : this(0, 0)
}
