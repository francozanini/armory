import React, {useEffect, useState} from "react";
import {Center} from "@chakra-ui/react";
import {Race} from "./Race";
import {RaceCard} from "./RaceCard";
import axios from "axios";

function RaceSelection() {
    const [races, setRaces] = useState<Race[]>([]);
    useEffect(() => {
        axios.get<Race[]>("http://localhost:8080/races")
            .then(resp => setRaces(resp.data));
    }, []);

    return (
        <>
            <Center flexWrap={"wrap"}>
                {races.map(race => <RaceCard race={race} styles={{marginBottom: "8px"}}/>)}
            </Center>
        </>
    );
}


export default RaceSelection
