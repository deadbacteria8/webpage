export interface User {
  id: string;
  name: string;
  title: string;
  avatar: string;
  connections: number;
  bio?: string;
}

export interface Post {
  id: string;
  author: User;
  content: string;
  image?: string;
  timestamp: string;
  likes: number;
  comments: number;
  shares: number;
}

export const currentUser: User = {
  id: 'me',
  name: 'Alex Morgan',
  title: 'Creative Technologist',
  avatar: 'https://media.istockphoto.com/id/1345388323/vector/human-silhouette-isolated-vector-icon.jpg?s=612x612&w=0&k=20&c=a1wg9LYywdqDUG-t9rifrf16XEdWZbWe7ajuYxJTxEI=',
  connections: 487,
  bio: 'Building digital experiences at the intersection of art and technology'
};

export const mockUsers: User[] = [
  {
    id: '1',
    name: 'Jordan Chen',
    title: 'UX Designer at TechCorp',
    avatar: 'https://media.istockphoto.com/id/1345388323/vector/human-silhouette-isolated-vector-icon.jpg?s=612x612&w=0&k=20&c=a1wg9LYywdqDUG-t9rifrf16XEdWZbWe7ajuYxJTxEI=',
    connections: 342
  },
  {
    id: '2',
    name: 'Sarah Kim',
    title: 'Product Manager at StartupX',
    avatar: 'https://media.istockphoto.com/id/1345388323/vector/human-silhouette-isolated-vector-icon.jpg?s=612x612&w=0&k=20&c=a1wg9LYywdqDUG-t9rifrf16XEdWZbWe7ajuYxJTxEI=',
    connections: 521
  },
  {
    id: '3',
    name: 'Marcus Rodriguez',
    title: 'Software Engineer at Digital Labs',
    avatar: 'https://media.istockphoto.com/id/1345388323/vector/human-silhouette-isolated-vector-icon.jpg?s=612x612&w=0&k=20&c=a1wg9LYywdqDUG-t9rifrf16XEdWZbWe7ajuYxJTxEI=',
    connections: 298
  },
];

export const mockPosts: Post[] = [
  {
    id: '1',
    author: mockUsers[0],
    content: 'Some building',
    image: 'https://cdn.apartmenttherapy.info/image/upload/f_auto,q_auto:eco,c_fit,w_730,h_500/at%2Farchive%2Fc5048c65338dab95df6e33a3a36059bea6dcc15f',
    timestamp: '2h ago',
    likes: 127,
    comments: 23,
    shares: 8
  },
  {
    id: '2',
    author: mockUsers[1],
    content: 'Just wrapped up an incredible product strategy session. Key takeaway: Listen to your users, but don\'t just build what they ask for. Solve the underlying problem. That\'s where innovation happens.',
    timestamp: '5h ago',
    likes: 84,
    comments: 15,
    shares: 4
  },
  {
    id: '3',
    author: mockUsers[2],
    content: 'Some building',
    image: 'https://cdn.apartmenttherapy.info/image/upload/f_auto,q_auto:eco,c_fit,w_730,h_500/at%2Farchive%2Fc5048c65338dab95df6e33a3a36059bea6dcc15f',
    timestamp: '1d ago',
    likes: 203,
    comments: 41,
    shares: 19
  },
];
