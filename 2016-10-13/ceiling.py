string=""
        

class Node(object):
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

    def add(self, n):
        if self.value < n:
            if self.right != None: 
                self.right.add(n)
            else:
                self.right = Node(n)
        else:
            if self.left != None:
                self.left.add(n)
            else:
                self.left = Node(n)

    def get_pattern(self):
        global string
        # left 
        if self.left != None:
            self.left.get_pattern()
        
        # root
        if self.left and self.right:
            string += 'B'
        elif self.left:
            string += 'L'
        elif self.right:
            string += 'R'
        else:
            string += 'N'
        

        # right
        if self.right != None:
            self.right.get_pattern()

def create_tree(M):
    elems = list(map(int, input().split(' ')))
    root = Node(elems[0]) 

    for elem in elems[1:]:
        root.add(elem)

    return root

def inOrder(root):
    if not root:
        return None
    
    inOrder(root.left)
    print(root.value)
    inOrder(root.right)

def main():
    global string
    N, M = tuple(map(int, input().split(' ')))

    patterns = set()

    for i in range(N):
        string = ""

        # Create new tree
        tree = create_tree(M)
        tree.get_pattern()
        patterns.add(string)

    
    print(len(patterns))

if __name__ == '__main__':
    main()