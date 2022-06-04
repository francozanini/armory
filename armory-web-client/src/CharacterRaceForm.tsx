import React, {useEffect, useState} from "react";
import {Center} from "@chakra-ui/react";
import {Race} from "./Race";
import {RaceCard} from "./RaceCard";

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
