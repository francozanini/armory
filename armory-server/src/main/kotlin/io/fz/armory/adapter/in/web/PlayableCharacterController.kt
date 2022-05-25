import CreateCharacterCommand.CreateCharacterCommand
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("playable-character")
class PlayableCharacterController {
    @PostMapping
    fun create(@RequestBody createCharacterCommand: CreateCharacterCommand): ResponseEntity<Boolean> {
        return ResponseEntity.ok(true)
    }
}