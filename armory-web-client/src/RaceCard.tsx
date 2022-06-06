import {Race} from "./Race";
import React, {useEffect, useState} from "react";
import {
    Box,
    Button,
    Flex,
    Image,
    Modal,
    ModalBody,
    ModalCloseButton,
    ModalContent,
    ModalFooter,
    ModalHeader,
    ModalOverlay,
    useDisclosure
} from "@chakra-ui/react";
import axios from "axios";

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

function RaceSelectionModal({raceId, isOpen, onClose}: { raceId: string, isOpen: boolean, onClose: () => void }) {
    const [race, setRace] = useState<Race>();
    useEffect(() => {
        axios.get<Race>(`http://localhost:8080/races/${raceId}`)
            .then(response => setRace(response.data))
    }, [])

    return <Modal isOpen={isOpen} onClose={onClose}>
        <ModalOverlay/>
        <ModalContent>
            <ModalHeader>{race?.raceName}</ModalHeader>
            <ModalCloseButton/>
            <ModalBody>
                {raceId}
            </ModalBody>

            <ModalFooter>
                <Button colorScheme='blue' mr={3} onClick={onClose}>
                    Close
                </Button>
                <Button variant='ghost'>Choose Race</Button>
            </ModalFooter>
        </ModalContent>
    </Modal>
}
