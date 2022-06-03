import {FormControl, FormLabel, Select} from "@chakra-ui/react";
import React from "react";
import {withBlackBox} from "./WithBlackBox";

function CharacterRaceForm() {
    return (
        <FormControl>
            <FormLabel>Race</FormLabel>
            <Select placeholder=" ">
                <option value="human">Human</option>
                <option value="dwarf">Dwarf</option>
            </Select>
        </FormControl>
    )
}

export default withBlackBox(CharacterRaceForm)