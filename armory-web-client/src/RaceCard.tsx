import {Race} from "./Race";
import React from "react";
import {Box, Flex, Image, useDisclosure} from "@chakra-ui/react";
import {RaceSelectionModal} from "./RaceSelectionModal";

export function RaceCard({race, styles}: { race: Race, styles?: React.CSSProperties }) {
    const {id, raceName, avatarUrl, sourceBook} = race;
    const {isOpen, onOpen, onClose} = useDisclosure();

    return (
        <>
            <Box background={"blackAlpha.600"}
                 p={[0.5]}
                 borderRadius="lg"
                 flexBasis={["xl", "3xl", "4xl", "5xl"]}
                 style={styles}
                 cursor={"pointer"}
            >
                <Flex flexDirection={"row"} ml={3} alignItems={"center"} onClick={onOpen}>
                    <Image boxSize="50px"
                           src={avatarUrl}
                           alt="race-image"></Image>
                    <Flex m={[2, 3]} gap={1} flexDirection={"column"}>
                        <strong>{raceName}</strong>
                        <em>{sourceBook}</em>
                    </Flex>
                </Flex>
            </Box>

            <RaceSelectionModal {...{raceId: id, isOpen, onClose}}></RaceSelectionModal>
        </>);
}

