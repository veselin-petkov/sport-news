import React, { useContext } from "react";
import {
  BoldLink,
  BoxContainer,
  FormContainer,
  Input,
  MutedLink,
  SubmitButton,
} from "./common";
import { Marginer } from "../marginer";
import { AccountContext } from "./accountContext";
import RegisterService from "../../services/RegisterService";

export function SignupForm(props) {
  const { switchToSignin } = useContext(AccountContext);

  
  return (
    <BoxContainer>
      <FormContainer>
        <Input type="text" placeholder="Username" id="username"/>
        <Input type="email" placeholder="Email" id="email"/>
        <Input type="password" placeholder="Password" id="password"/>
        <Input type="password" placeholder="Confirm Password" />
      </FormContainer>
      <Marginer direction="vertical" margin={10} />
      <SubmitButton type="submit" onClick = {RegisterService.createUser}>Signup</SubmitButton>
      <Marginer direction="vertical" margin="1em" />
      <MutedLink href="#">
        Already have an account?
        <BoldLink href="#" onClick={switchToSignin}>
          Signin
        </BoldLink>
      </MutedLink>
    </BoxContainer>
  );
}
