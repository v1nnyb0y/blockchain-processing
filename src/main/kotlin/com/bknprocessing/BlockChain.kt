package com.bknprocessing

import com.bknprocessing.node.Node

class BlockChain<T> {
    val chain: ArrayList<Node<T>> = ArrayList()

    fun addBlock(newNode: Node<T>) {
        newNode.also {
            it.previousHash = chain[chain.lastIndex].hash
            it.hash = newNode.calculateHash()
        }
        chain.add(newNode)
    }

    fun isChainValid(): Boolean {
        for (i in 1..chain.lastIndex) {
            if (chain[i].hash !== chain[i].calculateHash()) {
                return false
            }

            if (chain[i].previousHash !== chain[i - 1].hash) {
                return false
            }
        }

        return true
    }
}