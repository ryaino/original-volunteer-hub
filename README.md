# red-frogs-volunteer-hub

This repository has been abandoned and the current version of the project can be tracked here: https://gitlab.com/red-frogs-developers/volunteer-hub-webapp

This version of the project started out as somewhat of a dream that involved helping a local organization while also managing a project and small team at the same time. The original plan was for me to begin the project myself but eventually find some others to help me. This would mean I could focus on what I knew best; java backend, while I could get someone else to handle the frontend. The resulting tech stack was Angular + Java + Firebase. 

When starting I wanted to try and follow best practices wherever possible. This meant creating issues for everything, using git-flow with feature branches and even adding comments to my code *gasp*!. I event set up Jira and Confluence workspaces in anticipation of more people coming on board. Here is what the initial design doc and MVP requirements looked like: [Initial design spec and MVP requirements](https://github.com/ryaino/original-volunteer-hub/files/9125226/RFVH-RedFrogsVolunteerHubHome-160722-0533.pdf)

After a few months there were multiple things that resulted in starting over and moving over to the new repository. This repository was kept for reasons I will get into later on.  



### I realized there was no need for a backend
Seeing as I was using firebase as my backend and I didn't need any actual server-side logic, having spring running in the middle of all of my requests was quite pointless. I was just creating double the work for no gain. It also didn't help that I had no idea what I was doing when it came to trying to get authentication working when going Angular -> Spring -> Firebase and then back on every request.

### It became clear I was going to be on my own for this project
Basically I don't have any friends that are developers and I also put an ad out in the organization that the project was being created for, with no responses. 

### I was spending too much time messing around with the project management side of things
Much of my time was spent thinking about the project and trying to put into writing all of the plans I had rather than actually just getting even a proof of concept or MVP working. 

## The New Project
Eventually I decided to restart the project from scratch, making sure to learn from these mistakes and so I made sure to keep a few things in mind.
* I knew I was in this alone
* I needed to keep the technology stack small and familiar. Angular and Firebase should be everything I need.
* I shouldn't waste time on admin. I needed to just knuckle down and prioritize getting a working MVP. 

The biggest hurdle when getting started this time was my lack of confidence and knowledge when it came to frontend development. Fortunately there are three main resources I attribute to getting over this hump. 

### Angular Udemy Course
Ever since I was at university I've loved Angular and been really fascinated by it. I had no formal training with it and everything I knew was self taught. Back in 2019 I enrolled in a Udemy course to build on the miniaml foundation I had gained from youtube tutorials. This was a massive failure. I'm not really sure what the reason was, but I ended up giving up on the course while also not retaining much of what I did learn. Fast forward now to 2022 and I knew that if I wanted to get this project finished, then I needed to learn Angular for real. I started the course again from the beginning and everything just instantly clicked with me this time. I was fully hooked and every spare moment I had for the next two weeks was spent learning Angular. As a result I'm happy to share that I finished the course and as a result got this fancy certificate: https://www.udemy.com/certificate/UC-46bdc727-196c-4e84-9457-bf693e848a06/

### Grid Critters
It's all well and good to be able to work with Angular, but I was still missing one of the most important aspects of frontend dev; page layout. This is where [Grid Critters](https://gridcritters.com/) comes in. Never in my life have I found a resource that has been so effective in teaching me something and making sure I retain that knowledge while having fun at the same time. I can't begin to express how incredible I think this is as a learning tool and I wish there were more tools like this out there.

### Tailwind CSS
Alongside laying things out on a page I still needed to make them look good. I knew the basics of css and from a conceptual standpoint I really liked Sass so that's what I first chose to use. I kind of hated it from the beginning but I didn't think I had a choice. Then I cam across Tailwindcss, who's main selling point was reducing the mental load of managing css. Especially with Sass it felt like I had a complely different element to my tech stack seperate from the frontend that required just as much work. Tailwind made styling my components easy, enjoyable and quick. I don't think I'll be able to go back to using anything else. 

## Why this repository still exists
There's really only one reason this repository still exists. I'm honestly just really proud of the solution I implemented in the backend for interacting with Firestore. I was really stupid and didn't check for any existing libraries to make this easier so I ended up starting my own implementation from scratch. I'm just super happy with how easily expandable I made everything. I only got as far as having a Users collection to query but I took the time to create amazing building blocks for future expansion. The Abstract Controller, Document, Service and Repository classes I created are some of the best programming I have ever done I think. They were all done 100% on my own without any help or inspiration. So yeah this repository basically exists so that I'll always have those classes available to look back on as what I consider my first "good" fully original group of code. And before anyone asks, I didn't actually know reactive programming in Spring existed until after I abandonded this repo 😅 
