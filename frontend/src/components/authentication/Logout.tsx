import {useTheme} from "@mui/material";
import {tokens} from "../../theme";
import {useNavigate} from "react-router-dom";
import {useDispatch} from "react-redux";
import {Dispatch} from "../../redux/store";


const Logout = () => {
    const theme = useTheme();
    const colors = tokens(theme.palette.mode);
    const navigateTo = useNavigate();
    const dispatch = useDispatch<Dispatch>()

    return (
        <div>
            You're now logged out!
        </div>
    );
}

export default Logout;