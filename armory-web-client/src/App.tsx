import {
    Box,
    Button,
    Container,
    Flex,
    FormControl,
    FormLabel,
    Input,
    Select,
    Table,
    TableContainer,
    Tbody,
    Td,
    Th,
    Thead,
    Tr
} from '@chakra-ui/react'

import './App.css'
import {useState} from "react";

class Ability {
    public static STR = new Ability("Strength", 10);
    public static DEX = new Ability("Dexterity", 10);
    public static CON = new Ability("Constitution", 10);
    public static INT = new Ability("Intelligence", 10);
    public static WIS = new Ability("Wisdom", 10);
    public static CHA = new Ability("Charisma", 10);

    private constructor(public readonly name: string, private _score: number) {
        if (_score > 20 || _score < 0) throw Error("Ability score out of bounds");
    }

    public get score(): number {
        return this._score;
    }

    public modifier(): number {
        if (this._score < 2) return -5;
        if (this._score < 4) return -4;
        if (this._score < 6) return -3;
        if (this._score < 8) return -2;
        if (this._score < 10) return -1;
        if (this._score < 12) return 0;
        if (this._score < 14) return 1;
        if (this._score < 16) return 2;
        if (this._score < 18) return 3;
        if (this._score < 20) return 4;
        else return 5;
    }

    increaseScore(): number {
        if (this._score < 20) {
            this._score += 1;
        }
        return this._score;
    }

    decreaseScore(): number {
        if (this._score > 0) {
            this._score -= 1;
        }
        return this._score;
    }
}

function AbilityRow({ability}: { ability: Ability }) {
    const [score, setScore] = useState(ability.score)

    return <Tr>
        <Td>{ability.name}</Td>
        <Td textAlign={"center"}>{score}</Td>
        <Td textAlign={"center"}>{ability.modifier()}</Td>
        <Td>
            <Button onClick={() => setScore(ability.decreaseScore())} marginRight={1}>-</Button>
            <Button onClick={() => setScore(ability.increaseScore())}>+</Button>
        </Td>
    </Tr>;
}

const Abilities = () => {
    const abilities = [Ability.STR, Ability.DEX, Ability.CON, Ability.INT, Ability.WIS, Ability.CHA]

    return (
        <TableContainer>
            <Table>
                <Thead>
                    <Tr>
                        <Th>Ability</Th>
                        <Th isNumeric>Score</Th>
                        <Th isNumeric>Mod</Th>
                        <Th></Th>
                    </Tr>
                </Thead>
                <Tbody>
                    {abilities.map(ability =>
                        (<AbilityRow ability={ability}/>))}
                </Tbody>
            </Table>
        </TableContainer>
    )
}


function App() {
    return (
        <Container>
            <Box background={"blackAlpha.600"} m={[2, 3]} p={[1, 2]} borderRadius='lg' shadow={"xl"}>
                <Flex m={[2, 3]} gap={5} flexDirection={"column"}>
                    <FormControl>
                        <FormLabel>Name</FormLabel>
                        <Input placeholder=' '/>
                    </FormControl>
                    <FormControl>
                        <FormLabel>Class</FormLabel>
                        <Select placeholder=' '>
                            <option value='fighter'>Fighter</option>
                            <option value='cleric'>Cleric</option>
                        </Select>
                    </FormControl>
                    <FormControl>
                        <FormLabel>Race</FormLabel>
                        <Select placeholder=' '>
                            <option value='human'>Human</option>
                            <option value='dwarf'>Dwarf</option>
                        </Select>
                    </FormControl>
                    <Abilities/>
                </Flex>
            </Box>
        </Container>)
}

export default App
