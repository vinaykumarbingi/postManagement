package com.springjdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springjdbc.dao.CommentDaoImpl;
import com.springjdbc.dao.PostDaoImpl;
import com.springjdbc.dao.UserDaoImpl;
import com.springjdbc.entity.Comment;
import com.springjdbc.entity.Post;
import com.springjdbc.entity.User;

public class App 
{
    public static void main( String[] args ) 
    {
        System.out.println( "!!**==Welcome to Post Management App==**!!");
        String userInput;
        int choice=-1;
        Scanner sc =new Scanner(System.in);
        
        ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
		UserDaoImpl userDaoImpl=context.getBean(UserDaoImpl.class);
		PostDaoImpl postDaoImpl=context.getBean("postDaoImpl",PostDaoImpl.class);
		CommentDaoImpl commentDaoImpl=context.getBean("commentDaoImpl",CommentDaoImpl.class);
        
        do {
        	System.out.println("-------------------------------------");
        	System.out.println("--OPTIONS--");
        	System.out.println("1. Log-In");
        	System.out.println("2. Sign-Up");
        	System.out.println("3. Exit");
        	System.out.println("Enter the option:");
        	userInput=sc.nextLine();
        	try {
				choice=Integer.parseInt(userInput);
			}catch(NumberFormatException ex)
			{
				System.out.println("Please enter choice in digit only!");
				continue;
			}
			if(choice<1 || choice >3)
			{
				System.out.println("Please enter valid choice in digit!");
				continue;
			}
			switch(choice)
			{
			case 1:
				System.out.println("Please enter your credentials:");
				System.out.println("username:");
				String username=sc.nextLine();
				System.out.println("password:");
				String password1=sc.nextLine();
				User userlogin=userDaoImpl.authentication(username, password1);
				int userid = 0;
				try {
				//int loginId=userlogin.getId();
				//System.out.println(loginId);
				userid=userlogin.getId();
				}catch(Exception e){System.out.println("if not registered. then please register");}
				
				if(userid>0)
				{
					
				
					System.out.println("Post Management App Features:\r\n"
							+ "1. Display my posts. \r\n"
							+ "2. Display specific post.  \r\n"
							+ "3. Add Post.  \r\n"
							+ "4. Edit Post.\r\n"
							+ "5. Delete Post.  \r\n"
							+ "6. Add Comment. \r\n"
							+ "7. Edit Comment. \r\n"
							+ "8. Delete Comment.\r\n"
							+ "9. Logout \r\n");
					int ch=-1;
					String userIp;
					do
					{
						System.out.println("Please enter your choice:");
						userIp=sc.nextLine();
						try {
							ch=Integer.parseInt(userIp);
						}catch(NumberFormatException ex)
						{
							System.out.println("Please enter choice in digit only!");
							continue;
						}
						if(choice<1 || choice >9)
						{
							System.out.println("Please enter valid choice in digit!");
							continue;
						}
						switch(ch)
						{
						//display my posts
						case 1:
							
							//System.out.println("===Post Content===");
							//System.out.println("===Comments===");
							//System.out.println(postDaoImpl.getAllPosts());
							List<Post> postList=postDaoImpl.getAllPosts(userid);
							//System.out.println(postList.toString());
							System.out.println("Post Title======Post Content=======comments===");
							for(Post post: postList)
							{
								
								System.out.print(post.getPost_title()+"------"+post.getPost_content()+"------");
								List<Comment> commentList=commentDaoImpl.getAllComments(post.getId());
								List<String> str=new ArrayList<String>();
								for(Comment comment: commentList)
								{
									str.add(comment.getComment_content());
									//System.out.print(comment.getComment_content()+",  ");
								}
								String commaSeparatedValues = String.join(", ", str);

								System.out.print(commaSeparatedValues);
								System.out.println();
							}
							System.out.println("-------------------------------------");
							break;
						//display specific post
						case 2:
							System.out.println("Enter post ID: ");
							int postId=sc.nextInt();
							sc.nextLine();
							
							Post post=postDaoImpl.getPost(postId);
							System.out.println("Post Title======Post Content=======comments===");
							//System.out.println("===Post Title===");
							//System.out.println(post.getPost_title());
							//System.out.println("===Post Content===");
							//System.out.println(post.getPost_content());
							//System.out.println("===Comments===");
							System.out.print(post.getPost_title()+"-----"+post.getPost_content()+"-------");
							List<Comment> commentList=commentDaoImpl.getAllComments(postId);
							for(Comment comment: commentList)
							{
								
								System.out.print(comment.getComment_content()+",  ");
							}
							System.out.println();
							System.out.println("------------------------------------------");
							break;
						//add post
						case 3:
							System.out.println("Enter post Title: ");
							String postTitle=sc.nextLine();
							System.out.println("Enter post Content: ");
							String postContent=sc.nextLine();
							Post postObj=new Post();
							postObj.addPost(postTitle, postContent, userid);
							int result1=postDaoImpl.addPost(postObj);
							if(result1==1)
							{
								System.out.println("post saved successfully!!");
								System.out.println("---------------------------");
							}
							
							break;
							
						//edit post
						case 4:
							System.out.println("Enter post Id: ");
							int postId1=sc.nextInt();
							sc.nextLine();
							System.out.println("Enter post Title: ");
							String postTitle1=sc.nextLine();
							System.out.println("Enter post Content: ");
							String postContent1=sc.nextLine();
							Post postEdit=new Post(postId1, postTitle1, postContent1, userid);
							int result2=postDaoImpl.editPost(postEdit);
							if(result2==1)
							{
								System.out.println("post edited successfully!!");
								System.out.println("--------------------------------");
							}
							
							break;
						//delete post
						case 5:
							System.out.println("Enter post Id: ");
							int postId2=sc.nextInt();
							sc.nextLine();
							int result3=postDaoImpl.deletePost(postId2, userid);
							if(result3==1)
							{
								System.out.println("post deleted successfully!!");
								System.out.println("------------------------------");
							}
							//
							break;
						//add comment
						case 6:
							System.out.println("Enter post Id: ");
							int postId3=sc.nextInt();
							sc.nextLine();
							System.out.println("Enter comment content: ");
							String commentContent=sc.nextLine();
							Comment comment=new Comment();
							comment.addComment(commentContent, postId3);
							int result4=commentDaoImpl.addComment(comment);
							if(result4==1)
							{
								System.out.println("comment added successfully to the post!!");
								System.out.println("----------------------------------------");
							}
							
							break;
						//edit comment
						case 7:
							System.out.println("Enter Comment Id:");
							int commentId=sc.nextInt();
							sc.nextLine();
							System.out.println("Enter Comment Content:");
							String commentContent1=sc.nextLine();
							int result5=commentDaoImpl.editComment(commentId, commentContent1);
							if(result5==1)
							{
								System.out.println("Comment edited successfully!!!");
								System.out.println("--------------------------------");
							}
							
							break;
						//delete comment
						case 8:
							System.out.println("Enter Comment Id:");
							int commentId1=sc.nextInt();
							sc.nextLine();
							int result6=commentDaoImpl.deleteComment(commentId1);
							if(result6==1)
							{
								System.out.println("Comment deleted successfully!!!");
								System.out.println("--------------------------------");
							}
							//
							break;
						default:
							break;
							
						}
						
					}while(ch!=9);
				}
//				else
//				{
//					System.out.println("Please enter valid credentials!!!");
//				}
				
				break;
			case 2:
				
				System.out.println("Please enter your details to create account:");
				System.out.println("First Name:");
				String first_name=sc.nextLine();
				System.out.println("Last Name:");
				String last_name=sc.nextLine();
				System.out.println("Username:");
				String user_name=sc.nextLine();
				System.out.println("Password:");
				String password=sc.nextLine();
				System.out.println("Mobile Number:");
				long mobile_number=sc.nextLong();
				sc.nextLine();
				System.out.println("email id:");
				String email_address=sc.nextLine();
				User user=new User();
				user.register(first_name, last_name, user_name, password, mobile_number, email_address);
				int result=userDaoImpl.registration(user);
				if(result==1)
				{
					System.out.println("user profile created.!!");
					System.out.println("-----------------------------------");
				}
				break;
			default:
				break;
			}
			
        }while(choice!=3);
        sc.close();
    }
}
