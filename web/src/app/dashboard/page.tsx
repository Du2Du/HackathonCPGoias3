import styles from "@/app/dashboard/Dashboard.module.scss";
import {NavBar} from "@/components/navbar";
import {Dash} from "@/components/dash";

export default function Dashboard() {
    return (
        <main className={styles.sideBar}>
            <NavBar />
            <Dash/>
        </main>
    )
}
