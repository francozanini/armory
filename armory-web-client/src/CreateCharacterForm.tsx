import {Tab, TabList, TabPanel, TabPanels, Tabs} from "@chakra-ui/react";
import {BlackBox} from "./BlackBox";
import {Abilities} from "./Abilities";
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
                <BlackBox>
                    <CharacterDetailsForm/>
                </BlackBox>
            </TabPanel>
            <TabPanel>
                <BlackBox>
                    <CharacterRaceForm/>
                </BlackBox>
            </TabPanel>
            <TabPanel>
                <BlackBox>
                    <CharacterClassForm/>
                </BlackBox>
            </TabPanel>
            <TabPanel>
                <BlackBox>
                    <Abilities/>
                </BlackBox>
            </TabPanel>
        </TabPanels>
    </Tabs>;
}