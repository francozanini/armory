import {FormControl, FormLabel, Input} from "@chakra-ui/react";
import React from "react";
import {withBlackBox} from "./WithBlackBox";

function CharacterDetailsForm() {
    return <FormControl>
        <FormLabel>Name</FormLabel>
        <Input placeholder=" "/>
    </FormControl>;
}

export default withBlackBox(CharacterDetailsForm)