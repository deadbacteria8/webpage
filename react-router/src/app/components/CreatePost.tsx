
import { Image, Video, FileText } from 'lucide-react';
import { currentUser } from '../data/mockData';
import { AnimatedCard } from './ui/AnimatedCard';
import { ActionButton } from './ui/ActionButton';
import { Avatar } from './ui/Avatar';

export function CreatePost() {
  return (
      <AnimatedCard>
        <div className="flex gap-3 mb-4">
          <Avatar src={currentUser.avatar} alt={currentUser.name} />

          <button className="flex-1 text-left px-4 py-3 border border-gray-300 hover:border-black transition-colors text-gray-600">
            Share your thoughts...
          </button>
        </div>

        <div className="flex items-center justify-around pt-4 border-t border-gray-200">
          <ActionButton icon={Image} label="PHOTO" />
          <ActionButton icon={Video} label="VIDEO" />
          <ActionButton icon={FileText} label="ARTICLE" />
        </div>
      </AnimatedCard>
  );
}