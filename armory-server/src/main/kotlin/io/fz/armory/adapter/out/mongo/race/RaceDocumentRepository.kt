package io.fz.armory.adapter.out.mongo.race

import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface RaceDocumentRepository : ReactiveMongoRepository<RaceDocument, String>