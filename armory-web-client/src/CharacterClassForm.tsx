import {FormControl, FormLabel, Select} from "@chakra-ui/react";
import React from "react";

export default function CharacterClassForm() {
    return <FormControl>
        <FormLabel>Class</FormLabel>
        <Select placeholder=" ">
            <option value="fighter">Fighter</option>
            <option value="cleric">Cleric</option>
        </Select>
    </FormControl>;
}