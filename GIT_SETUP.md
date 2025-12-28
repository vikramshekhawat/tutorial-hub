# Git Repository Setup Guide

Follow these steps to connect your project to a Git repository and push your code.

## Step 1: Initialize Git Repository (if not already done)

```bash
git init
```

## Step 2: Add All Files to Git

```bash
git add .
```

## Step 3: Create Initial Commit

```bash
git commit -m "Initial commit: Spring Boot + React Tutorial Hub application"
```

## Step 4: Create a New Repository on GitHub/GitLab/Bitbucket

### Option A: Using GitHub
1. Go to [GitHub.com](https://github.com) and sign in
2. Click the "+" icon in the top right corner
3. Select "New repository"
4. Enter repository name (e.g., "tutorial-hub")
5. Choose Public or Private
6. **DO NOT** initialize with README, .gitignore, or license (we already have these)
7. Click "Create repository"

### Option B: Using GitLab
1. Go to [GitLab.com](https://gitlab.com) and sign in
2. Click "New project" or "+" → "New project/repository"
3. Enter project name
4. Choose visibility level
5. **DO NOT** initialize with README
6. Click "Create project"

## Step 5: Connect Local Repository to Remote

After creating the repository, you'll get a URL. Use one of these commands:

### For HTTPS (recommended for beginners):
```bash
git remote add origin https://github.com/YOUR_USERNAME/YOUR_REPO_NAME.git
```

### For SSH (if you have SSH keys set up):
```bash
git remote add origin git@github.com:YOUR_USERNAME/YOUR_REPO_NAME.git
```

**Replace `YOUR_USERNAME` and `YOUR_REPO_NAME` with your actual values.**

## Step 6: Verify Remote Connection

```bash
git remote -v
```

This should show your remote repository URL.

## Step 7: Push Code to Remote Repository

```bash
git branch -M main
git push -u origin main
```

If you're using `master` instead of `main`:
```bash
git branch -M master
git push -u origin master
```

## Step 8: Verify Push

Go to your repository on GitHub/GitLab and verify that all your files are there.

---

## Quick Command Summary

```bash
# Initialize repository
git init

# Add all files
git add .

# Create initial commit
git commit -m "Initial commit: Spring Boot + React Tutorial Hub application"

# Add remote repository (replace with your URL)
git remote add origin https://github.com/YOUR_USERNAME/YOUR_REPO_NAME.git

# Push to remote
git branch -M main
git push -u origin main
```

---

## Future Updates

After making changes to your code:

```bash
# Check status
git status

# Add changed files
git add .

# Commit changes
git commit -m "Description of your changes"

# Push to remote
git push
```

---

## Troubleshooting

### If you get "remote origin already exists":
```bash
git remote remove origin
git remote add origin YOUR_REPO_URL
```

### If you get authentication errors:
- For HTTPS: Use a Personal Access Token instead of password
- For SSH: Make sure your SSH key is added to your GitHub/GitLab account

### If you need to change remote URL:
```bash
git remote set-url origin NEW_REPO_URL
```

---

## Additional Git Commands

```bash
# View commit history
git log

# View current status
git status

# View remote repositories
git remote -v

# Pull latest changes
git pull

# Create a new branch
git checkout -b feature-branch-name

# Switch branches
git checkout branch-name
```

