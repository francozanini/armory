import React, {useEffect, useState} from "react";
import {Race} from "./Race";
import axios from "axios";
import {
    Button,
    Modal,
    ModalBody,
    ModalCloseButton,
    ModalContent,
    ModalFooter,
    ModalHeader,
    ModalOverlay
} from "@chakra-ui/react";

export function RaceSelectionModal({
                                       raceId,
                                       isOpen,
                                       onClose
                                   }: { raceId: string, isOpen: boolean, onClose: () => void }) {
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