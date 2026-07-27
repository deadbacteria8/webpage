import { ThumbsUp, MessageSquare, Share2, MoreHorizontal } from 'lucide-react';
import { Post } from '../data/mockData';
import { ImageWithFallback } from '../components/figma/ImageWithFallback';
import { Link } from 'react-router';
import { AnimatedCard } from './ui/AnimatedCard';
import { ActionButton } from './ui/ActionButton';
import { Avatar } from './ui/Avatar';

interface PostCardProps {
  post: Post;
}

export function PostCard({ post }: PostCardProps) {
  return (
      <AnimatedCard>

        <div className="flex items-start justify-between mb-4">
          <div className="flex gap-3">
            <Link to={`/profile/${post.author.id}`}>
              <Avatar src={post.author.avatar} alt={post.author.name} />
            </Link>
            <div>
              <Link to={`/profile/${post.author.id}`} className="font-bold hover:underline">
                {post.author.name}
              </Link>
              <p className="text-sm text-gray-600">{post.author.title}</p>
              <p className="text-xs text-gray-500 tracking-wider mt-1">{post.timestamp}</p>
            </div>
          </div>
          <button className="text-gray-500 hover:text-black">
            <MoreHorizontal className="w-5 h-5" />
          </button>
        </div>

        {/* Content */}
        <div className="mb-4">
          <p className="leading-relaxed">{post.content}</p>
        </div>

        {post.image && (
            <div className="mb-4 -mx-6">
              <ImageWithFallback
                  src={post.image}
                  alt="Post content"
                  className="w-full h-80 object-cover"
              />
            </div>
        )}

        <div className="flex items-center justify-between py-3 border-t border-b border-gray-200 text-sm text-gray-600 mb-2">
          <span>{post.likes} reactions</span>
          <div className="flex gap-4">
            <span>{post.comments} comments</span>
            <span>{post.shares} shares</span>
          </div>
        </div>

        <div className="flex items-center justify-around">
          <ActionButton icon={ThumbsUp} label="LIKE" />
          <ActionButton icon={MessageSquare} label="COMMENT" />
          <ActionButton icon={Share2} label="SHARE" />
        </div>
      </AnimatedCard>
  );
}