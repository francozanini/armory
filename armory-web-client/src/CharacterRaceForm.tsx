import React, {useEffect, useState} from "react";
import {Box, Center, Flex, Image} from "@chakra-ui/react";

function RaceCard({race, styles}: { race: Race, styles?: React.CSSProperties }) {
    const {raceName, avatarUrl, sourceBook} = race;

    return <Box background={"blackAlpha.600"}
                p={[0.5]}
                borderRadius="lg"
                flexBasis={["xl", "3xl", "4xl"]}
                style={styles}
    >
        <Flex flexDirection={"row"} ml={3} alignItems={"center"}>
            <Image boxSize="50px"
                   src={avatarUrl}
                   alt="race-image"></Image>
            <Flex m={[2, 3]} gap={1} flexDirection={"column"}>
                <strong>{raceName}</strong>
                <em>{sourceBook}</em>
            </Flex>
        </Flex>
    </Box>;
}

class Race {
    constructor(
        public readonly avatarUrl: string,
        public readonly raceName: string,
        public readonly sourceBook: string) {
    }
}

function CharacterRaceForm() {
    const [races, setRaces] = useState<Race[]>([]);
    useEffect(() => {
        fetch("http://localhost:8080/races")
            .then(resp => resp.json())
            .then(setRaces);
    }, [])

    return (
        <Center flexWrap={"wrap"}>
            {races.map(race => <RaceCard race={race} styles={{marginBottom: "8px"}}/>)}
        </Center>

    )
}

export default CharacterRaceForm
