import React from "react";
import {Box, Center, Flex, Image} from "@chakra-ui/react";

function CharacterRaceForm() {


    return (
        <Center flexWrap={"wrap"}>
            <Box background={"blackAlpha.600"}
                 p={[0.5]}
                 borderRadius='lg'
                 flexBasis={['xl', "3xl", "4xl"]}
            >
                <Flex flexDirection={"row"} ml={3} alignItems={'center'}>
                    <Image boxSize='50px'
                           src='https://www.dndbeyond.com/avatars/9/386/636327460764467148.jpeg?width=1000&height=1000&fit=bounds&quality=95&auto=webp'
                           alt="race-image"></Image>
                    <Flex m={[2, 3]} gap={1} flexDirection={"column"}>
                        <strong>Human</strong>
                        <em>Basic Rules / Player's Handbook</em>
                    </Flex>
                </Flex>
            </Box>
        </Center>

    )
}

export default CharacterRaceForm
