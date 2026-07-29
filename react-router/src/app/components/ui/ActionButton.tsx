export function ActionButton({ icon: Icon, label, ...props }: any) {
    return (
        <button
            className="flex items-center gap-2 px-4 py-2 hover:bg-gray-100 transition-colors flex-1"
            {...props}
        >
            <Icon className="w-5 h-5" />
            <span className="text-sm font-medium tracking-wide">{label}</span>
        </button>
    );
}