import {Tab, TabList, TabPanel, TabPanels, Tabs} from "@chakra-ui/react";
import Abilities from "./Abilities";
import React from "react";
import CharacterClassForm from "./CharacterClassForm";
import CharacterRaceForm from "./CharacterRaceForm";
import CharacterDetailsForm from "./CharacterDetailsForm";

export function CreateCharacterForm() {
    return <Tabs>
        <TabList>
            <Tab>Details</Tab>
            <Tab>Race</Tab>
            <Tab>Class</Tab>
            <Tab>Abilities</Tab>
        </TabList>
        <TabPanels>
            <TabPanel>
                <CharacterDetailsForm/>
            </TabPanel>
            <TabPanel>
                <CharacterRaceForm/>
            </TabPanel>
            <TabPanel>
                <CharacterClassForm/>
            </TabPanel>
            <TabPanel>
                <Abilities/>
            </TabPanel>
        </TabPanels>
    </Tabs>;
}