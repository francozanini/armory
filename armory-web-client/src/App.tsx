import {Box, Container, Flex, FormControl, FormLabel, Input, Select} from '@chakra-ui/react'

import './App.css'

function App() {
    return (
        <Container>
            <Box background={"blackAlpha.600"} m={[2, 3]} borderRadius='lg' shadow={"xl"}>
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
                </Flex>
            </Box>
        </Container>)
}

export default App
