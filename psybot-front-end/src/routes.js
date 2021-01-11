import App from "./App";
import Chat from "./Chat";


export default [
  {
    path: "/",
    exact: true,
    component: App
  },
  {
    path: "/chat",
    component: Chat
  }
];