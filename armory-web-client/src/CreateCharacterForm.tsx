import {FormControl, FormLabel, Input, Select, Tab, TabList, TabPanel, TabPanels, Tabs} from "@chakra-ui/react";
import {BlackBox} from "./BlackBox";
import {Abilities} from "./Abilities";
import React from "react";

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
                    <FormControl>
                        <FormLabel>Name</FormLabel>
                        <Input placeholder=" "/>
                    </FormControl>
                </BlackBox>
            </TabPanel>
            <TabPanel>
                <BlackBox>
                    <FormControl>
                        <FormLabel>Race</FormLabel>
                        <Select placeholder=" ">
                            <option value="human">Human</option>
                            <option value="dwarf">Dwarf</option>
                        </Select>
                    </FormControl>
                </BlackBox>
            </TabPanel>
            <TabPanel>
                <BlackBox>
                    <FormControl>
                        <FormLabel>Class</FormLabel>
                        <Select placeholder=" ">
                            <option value="fighter">Fighter</option>
                            <option value="cleric">Cleric</option>
                        </Select>
                    </FormControl>
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