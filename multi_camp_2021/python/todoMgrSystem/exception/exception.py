class NotFoundError(Exception):
    def __init__(self, msg):
        super().__init__(msg+" 존재하지 않습니다.\n")
    
    def __str__(self):
        return super().__str__()


class DuplicateError(Exception):
    def __init__(self, msg):
        super().__init__(msg+" 이미 존재합니다.\n")
    
    def __str__(self):
        return super().__str__()


