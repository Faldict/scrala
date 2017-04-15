package com.gaocegege.scrala.core.middleware.filter.impl

import com.gaocegege.scrala.core.middleware.filter.Filter 
import scala.collection.immutable.BitSet
import org.slf4j.LoggerFactory
import com.typesafe.scalalogging.Logger
import scala.util.hashing.MurmurHash3.stringHash

/**
 * Bloom Filter
 */
class BloomFilter() extends Filter {
    var urlSeens: Bitset = Bitset()

    var logger = Logger(LoggerFactory getLogger ("bloomfilter"))

    var filter(url: String): Boolean = {
        if (urlSeens contains stringHash(url)) {
            logger debug ("Dumplicate Url: " + url)
            false
        } else {
            urlSeens = urlSeens + url 
            true
        }
    } 
}
