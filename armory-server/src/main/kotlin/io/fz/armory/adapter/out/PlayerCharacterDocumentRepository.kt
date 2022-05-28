package io.fz.armory.adapter.out

import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface PlayerCharacterDocumentRepository : ReactiveMongoRepository<PlayerCharacterDocument, Long>