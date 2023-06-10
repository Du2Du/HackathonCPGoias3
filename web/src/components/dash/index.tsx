import styles from "@/components/dash/Dash.module.scss";
import Link from "next/link";

export const Dash = () => {
    return (
        <div className={styles.dash}>
            <div className={styles.dashBody}>
                <Link className={styles.dashItems} href={"/option-1"}>
                    <span className={styles.text}>Item 1</span>
                </Link>
                <Link className={styles.dashItems} href={"/option-2"}>
                    <span className={styles.text}>Item 2</span>
                </Link>
                <Link className={styles.dashItems} href={"/option-3"}>
                    <span className={styles.text}>Item 3</span>
                </Link>
            </div>
            <div className={styles.dashBody}>
                <Link className={styles.dashItems} href={"option-4"}>
                    <span className={styles.text}>Item 1</span>
                </Link>
                <Link className={styles.dashItems} href={"option-5"}>
                    <span className={styles.text}>Item 2</span>
                </Link>
                <Link className={styles.dashItems} href={"option-6"}>
                    <span className={styles.text}>Item 3</span>
                </Link>
            </div>
        </div>
    );
}
