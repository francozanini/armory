import {
    Box,
    Container,
    Flex,
    FormControl,
    FormLabel,
    Input,
    Select,
    Tab,
    TabList,
    TabPanel,
    TabPanels,
    Tabs
} from '@chakra-ui/react'

import './App.css'
import {Abilities} from "./Abilities";


function App() {
    return (
        <Tabs>
            <TabList>
                <Tab>Details</Tab>
                <Tab>Race</Tab>
                <Tab>Class</Tab>
                <Tab>Abilities</Tab>
            </TabList>
            <TabPanels>
                <TabPanel>
                    <Container>
                        <Box background={"blackAlpha.600"} m={[2, 3]} p={[0.5, 1]} borderRadius='lg' shadow={"xl"}>
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
                    </Container>
                </TabPanel>
                <TabPanel></TabPanel>
                <TabPanel></TabPanel>
                <TabPanel></TabPanel>
            </TabPanels>
        </Tabs>)

}

export default App
