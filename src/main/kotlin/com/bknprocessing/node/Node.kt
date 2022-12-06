package com.bknprocessing.node

import com.bknprocessing.utils.sha256
import java.time.OffsetDateTime

/**
 * A BlockChain Node
 *
 * This class has calculation of hashes and other logic connecting to the Node
 *
 * @param T the type of the DTO in the Node
 * @property index where the Node sits in the BlockChain
 * @property createdAt creation of the Node
 * @property data data in the Node
 * @property previousHash hash of the previous Node
 */
class Node<T>(
    private val data: T,
    var previousHash: String = "",
    private val index: Long? = null,
    private val createdAt: OffsetDateTime = OffsetDateTime.now()
) {
    var hash: String = ""

    init {
        hash = calculateHash()
    }

    fun calculateHash() = "$index$previousHash$createdAt$data".sha256()
}
