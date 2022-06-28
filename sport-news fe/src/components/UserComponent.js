import React from "react";
import UserService from "../services/UserService";

class UserComponent extends React.Component{

    constructor(props){
        super(props)
        this.state = {
            users:[]
        }
    }
    componentDidMount(){
        UserService.getUsers().then((response) =>{
            this.setState({users: response.data})
        });
    }

    renderSwitch(param) {
        switch(param) {
            case '1':
                return 'USER';
            case '2':
                return 'ADMIN';
            case '3':
                return 'MODERATOR';
            case '4':
                return 'BANNED';
          default:
            return 'USER';
        }
      }

render(){
    return(
        <div>
            <h1 className = "text-center"> Users List</h1>
            <table className="table table-striped">
                <thead>
                    <tr>
                        <td>User ID</td>
                        <td>User username</td>
                        <td>User email</td>
                        <td>User Role</td>
                    </tr>
                </thead>
                <tbody>
                    {
                        this.state.users.map(
                            user =>
                            <tr key = {user.id}>
                                <td> {user.id}</td>
                                <td> {user.username}</td>
                                <td> {user.email}</td>
                                <td>{this.renderSwitch(user.role_id)}</td>
                            </tr>
                        )
                    }
                </tbody>
            </table>
        </div>
    )
}
}

export default UserComponent;