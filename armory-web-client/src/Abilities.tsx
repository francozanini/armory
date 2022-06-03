import {Ability} from "./Ability";
import {Table, TableContainer, Tbody, Th, Thead, Tr} from "@chakra-ui/react";
import {AbilityRow} from "./AbilityRow";

export const Abilities = () => {
    const abilities = [Ability.STR, Ability.DEX, Ability.CON, Ability.INT, Ability.WIS, Ability.CHA]

    return (
        <TableContainer overflow={"hidden"}>
            <Table fontSize={"sm"}>
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
                        (<AbilityRow key={ability.name} ability={ability}/>))}
                </Tbody>
            </Table>
        </TableContainer>
    )
}