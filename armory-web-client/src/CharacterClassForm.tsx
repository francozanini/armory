import {FormControl, FormLabel, Select} from "@chakra-ui/react";
import React from "react";
import {withBlackBox} from "./WithBlackBox";

function CharacterClassForm() {
    return <FormControl>
        <FormLabel>Class</FormLabel>
        <Select placeholder=" ">
            <option value="fighter">Fighter</option>
            <option value="cleric">Cleric</option>
        </Select>
    </FormControl>;
}

export default withBlackBox(CharacterClassForm);