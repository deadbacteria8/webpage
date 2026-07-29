import { motion } from 'motion/react';

export function AnimatedCard({ children, className = "" }: {
    children: React.ReactNode;
    className?: string;
}) {
    return (
        <motion.div
            className={`bg-white p-6 ${className}`}
            initial={{ opacity: 0, y: 20 }}
            animate={{ opacity: 1, y: 0 }}
            transition={{ duration: 0.3 }}
        >
            {children}
        </motion.div>
    );
}