package io.fz.armory.adapter.out.mongo.playerCharacter

import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface PlayerCharacterDocumentRepository : ReactiveMongoRepository<PlayerCharacterDocument, String>