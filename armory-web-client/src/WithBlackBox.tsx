import {Box, Flex} from "@chakra-ui/react";
import React from "react";


export const withBlackBox = (Component: React.FC) => {
    return (props: any) => (
        <Box background={"blackAlpha.600"} m={[2, 3]} p={[0.5, 1]} borderRadius='lg' shadow={"xl"}>
            <Flex m={[2, 3]} gap={5} flexDirection={"column"}>
                <Component {...props}/>
            </Flex>
        </Box>
    )
};

export const BlackBox = (children: any[]): JSX.Element => (
    <Box background={"blackAlpha.600"} m={[2, 3]} p={[0.5, 1]} borderRadius='lg' shadow={"xl"}>
        <Flex m={[2, 3]} gap={5} flexDirection={"column"}>
            {children}
        </Flex>
    </Box>
);



