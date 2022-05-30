import {Center, Container, Flex, FormControl, FormLabel, Input, Select, Spacer} from '@chakra-ui/react'

import './App.css'

function App() {
    return (
        <Container centerContent>
            <Flex alignItems={"center"} justifyContent={"center"}>
                <Center>
                    <FormControl>
                        <FormLabel>First name</FormLabel>
                        <Input placeholder=' '/>
                    </FormControl>
                    <Spacer/>
                    <FormControl>
                        <FormLabel>Class</FormLabel>
                        <Select placeholder=' '>
                            <option value='option1'>Option 1</option>
                            <option value='option2'>Option 2</option>
                            <option value='option3'>Option 3</option>
                        </Select>
                    </FormControl>
                    <Spacer/>
                    <FormControl>
                        <FormLabel>Race</FormLabel>
                        <Select placeholder=' '>
                            <option value='option1'>Option 1</option>
                            <option value='option2'>Option 2</option>
                            <option value='option3'>Option 3</option>
                        </Select>
                    </FormControl>
                </Center>
            </Flex>
        </Container>)
}

export default App
