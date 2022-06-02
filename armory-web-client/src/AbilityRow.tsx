import {useState} from "react";
import {Button, Td, Tr} from "@chakra-ui/react";
import {Ability} from "./Ability";

export function AbilityRow({ability}: { ability: Ability }) {
    const [score, setScore] = useState(ability.score)

    return <Tr>
        <Td>{ability.name}</Td>
        <Td textAlign={"center"}>{score}</Td>
        <Td textAlign={"center"}>{ability.modifier()}</Td>
        <Td paddingX={1}>
            <Button onClick={() => setScore(ability.decreaseScore())} marginRight={1}>-</Button>
            <Button onClick={() => setScore(ability.increaseScore())}>+</Button>
        </Td>
    </Tr>;
}

