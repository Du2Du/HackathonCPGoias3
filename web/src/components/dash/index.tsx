import styles from "@/components/dash/Dash.module.scss";

export const Dash = () => {
    return (
        <div>
            <div className={styles.textTitle}>
                <h1>Dashboard</h1>
            </div>
            <div className={styles.dashBody}>
                <div className={styles.dashItems}>
                    Item 1
                </div>
                <div className={styles.dashItems}>
                    Item 2
                </div>
                <div className={styles.dashItems}>
                    Item 3
                </div>
            </div>
            <div className={styles.dashBody}>
                <div className={styles.dashItems}>
                    Item 1
                </div>
                <div className={styles.dashItems}>
                    Item 2
                </div>
                <div className={styles.dashItems}>
                    Item
                </div>
            </div>
        </div>
    );
}