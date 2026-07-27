// components/ui/Avatar.tsx
import {ImageWithFallback} from "../figma/ImageWithFallback";

export function Avatar({ src, alt, className = "" }: any) {
    return (
        <ImageWithFallback
            src={src}
            alt={alt}
            className={`w-12 h-12 object-cover border border-black ${className}`}
        />
    );
}