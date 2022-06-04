import {Race} from "./Race";
import React from "react";
import {Box, Flex, Image} from "@chakra-ui/react";

export function RaceCard({race, styles}: { race: Race, styles?: React.CSSProperties }) {
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