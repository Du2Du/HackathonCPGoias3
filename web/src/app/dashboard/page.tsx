import styles from "@/app/dashboard/Dashboard.module.scss";
import {NavBar} from "@/components/navbar";

export default function Dashboard() {
    return (
        <main className={styles.sideBar}>
            <NavBar />
        </main>
    )
}
